# opencv

A Clojure library designed to experiment with opencv.

## Build

mvn deploy:deploy-file -DgroupId=local -DartifactId=opencv \
  -Dversion=2.4.8 -Dpackaging=jar -Dfile=opencv-248.jar \
  -Durl=file:repo

## Usage

lein run resources/lena.png lena-detected.png

## License

Copyright © 2013 Kanwei Li

Distributed under the Eclipse Public License, the same as Clojure.
