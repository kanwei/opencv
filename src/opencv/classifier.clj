(ns opencv.classifier
  (:import
    org.opencv.core.Core
    org.opencv.core.Mat
    org.opencv.core.MatOfRect
    org.opencv.core.Point
    org.opencv.core.Rect
    org.opencv.core.Scalar
    org.opencv.highgui.Highgui
    org.opencv.objdetect.CascadeClassifier))

(clojure.lang.RT/loadLibrary Core/NATIVE_LIBRARY_NAME)

(defn classify [classifier-fname img-fname out-fname]
  (let [classifier (CascadeClassifier. classifier-fname)
        img (Highgui/imread img-fname)
        detections (MatOfRect.)]
    (.detectMultiScale classifier img detections)
    (doall (map (fn [rect]
                  (Core/rectangle img
                                  (Point. (.x rect) (.y rect))
                                  (Point. (+ (.x rect) (.width rect))
                                          (+ (.y rect) (.height rect)))
                                  (Scalar. 0 255 0)))
                (.toList detections)))
    (Highgui/imwrite out-fname img)))

#_(classify (.getPath (clojure.java.io/resource "haarcascade_frontalface_alt.xml"))
          (.getPath (clojure.java.io/resource "matt.png"))
          "matt-detected.png")