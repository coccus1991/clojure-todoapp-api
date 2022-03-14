(ns clojure-todoapp-api.core
  (:require
    [org.httpkit.server :as server]
    [compojure.core :as cmpj]
    [ring.middleware.json :as js]
    [ring.middleware.defaults :as md]
    [clojure-todoapp-api.handlers.task-handler :as task-handler]
    )
  (:gen-class))


(def basePath (str "/api/v1"))

(cmpj/defroutes app-router
                (cmpj/GET [(str basePath"/task/:id") :id #"[0-9]+"] [id] (task-handler/task-get id))
                (cmpj/GET (str basePath"/task") [] (task-handler/task-list))
                )

(defn -main
  []
  (server/run-server (js/wrap-json-params (js/wrap-json-response (md/wrap-defaults #'app-router md/api-defaults))) {:port 8080})
  (println (str "server ready")))

