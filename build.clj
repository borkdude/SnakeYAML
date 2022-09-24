(ns build
  (:require [clojure.tools.build.api :as b]
            [babashka.process :as p]
            [clojure.edn :as edn]))

(def project (-> (edn/read-string (slurp "deps.edn"))
                 :aliases :neil :project))
(def lib (or (:name project) 'io.github.borkdude/snakeyaml))

;; use neil project set version 1.2.0 to update the version in deps.edn

(def version (or (:version project)
                 "1.33"))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn compile-java [_]
  (b/javac {:src-dirs ["src/main/java"]
            :class-dir class-dir
            :basis basis
            :javac-opts ["-source" "8" "-target" "8"]}))


(defn jar [_]
  (compile-java {})
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]})
  (b/copy-dir {:src-dirs []
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn install [_]
  (jar {})
  (b/install {:basis basis
              :lib lib
              :version version
              :jar-file jar-file
              :class-dir class-dir}))

(defn deploy [opts]
  (jar opts)
  ((requiring-resolve 'deps-deploy.deps-deploy/deploy)
    (merge {:installer :remote
                       :artifact jar-file
                       :pom-file (b/pom-path {:lib lib :class-dir class-dir})}
                    opts))
  opts)

