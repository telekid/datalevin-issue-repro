(ns main
  (:gen-class)
  (:require [datalevin.core :as d]))

(def conn
  (d/create-conn "/Users/jake/.hypo2"))
