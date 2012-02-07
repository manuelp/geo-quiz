(ns geo-quiz.core)

(defn quiz
  "Ask n random capitals from the list."
  [n]
  (let [capitals [{:country "Italy" :capital "Rome"}
                  {:country "France" :capital "Paris"}
                  {:country "Germany" :capital "Berlin"}
                  {:country "United Kingdom" :capital  "London"}]]
    (letfn [(ask-capital [{:keys [country capital]}]
              (do
                (println (format "Enter the capital of %s: " country))
                (if (= (read-line) capital) 1 -1)))
            (ask-capitals [questions] (reduce + (map ask-capital questions)))]
      (ask-capitals (take n (shuffle capitals))))))
    
(println "RESULT: " (quiz 2))
