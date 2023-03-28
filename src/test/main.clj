(ns test.main
  (:gen-class)
  (:require [datalevin.core :as d]))

(defn -main [& args]
  (d/create-conn "/Users/jake/.hypo2"))
