(ns amicable.core
  (:require [clojure.math.numeric-tower :as math]
            [clojure.math.combinatorics :as comb]
            [clojure.core.reducers :as r]))

;;; Math

(defn sum-divisors
  [n]
  ;;actually incorrect for perfect squares, such as 16, but no amicable numbers seem to be perfect squares.
  ;;add (if (= (mod n (sqrt n)) 0)
  ;;       (conj n result-list))
  ;;not checking makes it faster
  (let [base (filter (fn [x] (zero? (mod n x))) (range 2 (Math/sqrt n)))]
    (reduce + 1 (concat (map (fn [x] (/ n x)) base) base))))

;;pure magic straight from clojure core.
(def memo-sum (memoize sum-divisors))

(defn amicable? [a b]
  (and (not= a b)
    (= a (memo-sum b))
    (= b (memo-sum a)))
)

(defn -main
  [x & args]
  (println "Adjust jvm opts in project.clj to fit memory size. Extremely heavy memory use.")
  (println
    (time
    ;; combinatorics is waaay too slow.
    ;;(doall
    ;;  (into []
    ;;    (r/filter (fn [a] (amicable? (first a) (second a)))
    ;;    (comb/combinations (range (read-string x)) 2))
    ;;))
    (r/reduce (fn boo [x s] (if (sequential? s) x (conj x s))) []
      (let [sums (into [] (r/map sum-divisors (range 1 (read-string x))))]
           (for [i (range 1 (read-string x))]
             (if (amicable? i (nth sums (dec i))) i []))))
 )))
