(defproject amicable "1.0"
  :description "FINAL RELEASE"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                  [org.clojure/math.numeric-tower "0.0.4"]
                  [org.clojure/math.combinatorics "0.1.1"]
                  [expectations "2.1.4"]]
  :plugins [[lein-expectations "0.0.7"]]
  ;;change this to amount of free memory. 2 gig minimum.
  :jvm-opts ["-Xmx2g"]
  :main amicable.core)
