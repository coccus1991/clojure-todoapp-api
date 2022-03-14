(ns clojure-todoapp-api.handlers.task-handler
  (:require [clojure.data.json :as json])
  (:gen-class))

(def taskListMock [
                   {"id" 1 "name", "first task" "completed" true}
                   {"id" 2 "name", "second task" "completed" false}])

(defn find-object-in-array
  "Find a object in array"
  [key value arr]
  (filter (fn [x] (= (get x key) value)) arr))


(defn task-list
  []
  (fn [req] {
             :status  200
             :headers {"Content-Type" "application/json"}
             :body    (json/write-str taskListMock)})
  )

(defn task-get
  [id]
  (let [item (first (find-object-in-array "id" (Integer/parseInt id) taskListMock))]
    (fn [req] {
               :status  (if (nil? item) 404 200)
               :headers {"Content-Type" "application/json"}
               :body    (if (nil? item) (str "Not Found") (json/write-str item))})
    ))