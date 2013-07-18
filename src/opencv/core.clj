(ns opencv.core
  (:gen-class)
  (:require [opencv.classifier :as classifier]))

(defn -main
  [& args]
  (if (>= (count args) 2)
    (classifier/classify (.getPath (clojure.java.io/resource "haarcascade_frontalface_alt.xml"))
                         (first args)
                         (second args))
    (println "Usage: lein run input.png output.png")))
