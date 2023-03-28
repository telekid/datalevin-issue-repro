(ns test.main
  (:gen-class)
  (:require [datalevin.core :as d]))

(defn -main [& _args]
  (let [conn (d/create-conn)]
    (d/transact! conn [{:a 1}])
    (println
     "Success:"
     (= 1
        (d/q '[:find ?v .
               :in $
               :where [_ :a ?v]]
             (d/db conn))))))
