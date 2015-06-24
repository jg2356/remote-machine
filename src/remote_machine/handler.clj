(ns remote-machine.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [remote-machine.visitor :refer [visit *symbols*]]))

(defapi app
  (context* 
    "/visit" []
    :tags ["visit"]
    (POST* 
      "/" []
      :return s/Any
      :body [tree s/Any]
      :summary "visits the tree"
      (ok (try 
            (binding [*symbols* (atom {})]
              (last (visit tree)))
            (catch Exception e
              (. e toString)))))))
