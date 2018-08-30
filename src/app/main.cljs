(ns app.main
  (:require [hyperapp :refer [h app]]))

(def state #js{:count 0})

(def actions
  #js{:down (fn [state]
              {:count (- (.-count state) 1)})
      :up (fn [state]
            {:count (+ (.-count state) 1)})})

(defn view [state actions]
  (h "div" #js{} #js[(h "h1" #js{} (.-count state))
                     (h "button" #js{:onclick (.-up actions)} "+")
                     (h "button" #js{:onclick (.-down actions)} "-")]))

(app state actions view js/document.body)