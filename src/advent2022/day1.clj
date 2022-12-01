(ns advent2022.day1
  (:require [clojure.java.io :as io]))

(defn ingest-input [filename]
  (->> filename
       io/resource
       io/reader
       line-seq))

(defn -main []
  (let [input (ingest-input "day1")]
    (->> input
         (partition-by empty?)
         (filter #(not-empty (first %))) ; There has got to be a better way
         (map #(map parse-long %))
         (map #(reduce + %))
         sort
         reverse
         (take 3)
         (reduce +))))
