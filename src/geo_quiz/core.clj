(ns geo-quiz.core)

(def capitals [{:country "Italy" :capital "Rome"}
               {:country "France" :capital "Paris"}
               {:country "Germany" :capital "Berlin"}
               {:country "United Kingdom" :capital  "London"}])

(defn ask-capital [question]
  (do
    (println (format "Enter the capital of %s: " (question :country)))
    (= (read-line) (question :capital))))

(defn calculate-points [points correct-answer]
  (if correct-answer
    (inc points)
    (dec points)))

(defn ask-capitals [questions]
  (loop [qs questions points 0]
    (if (empty? qs)
      points
      (recur (rest qs) (calculate-points points (ask-capital (first qs)))))))

(defn quiz [n questions]
  (ask-capitals (take n (shuffle capitals))))
    
(println "RESULT: " (quiz 2 capitals))
