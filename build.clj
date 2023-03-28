(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")

(def basis (b/create-basis {:project "deps.edn"}))

(def jar-file "target/hypo.jar")

(defn clean [_]
  (b/delete {:path "target"}))

(defn uberjar [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :java-opts ["--add-opens=java.base/java.nio=ALL-UNNAMED"
                              "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED"]
                  :src-dirs ["src"]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file jar-file
           :basis basis
           :main 'main}))
