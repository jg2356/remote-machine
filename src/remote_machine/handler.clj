(ns remote-machine.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [remote-machine.visitor :refer [visit *symbols*]]))

(defapi app
  (POST* 
    "/visit" []
    :return s/Any
    :body [tree s/Any]
    (ok (try
          (println "RCVD:\r\n" tree "\r\n") 
          (binding [*symbols* (atom {})]
            (let [result (last (visit tree))]
              (println "SEND:\r\n" result)
              result))
          (catch Exception e
            (. e toString))))))
