(ns app.main
  (:require [hyperapp :refer [h app]]))

(def state (clj->js {:count 0}))

(def actions
  (clj->js {:down (fn [value]
                   (fn [state]
                     {:count (- state.count value)}))
            :up (fn [value]
                  (fn [state]
                    {:count (+ state.count value)}))}))

(defn view [state actions]
  (h "div" #js{} #js[(h "h1" #js{} state.count)
                     (h "button" #js{:onclick ((:up actions) 1)} "+")
                     (h "button" #js{:onclick ((:down actions) 1)} "-")]))

(app state actions view js/document.body)