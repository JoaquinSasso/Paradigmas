sinRepetir :: Eq a => [a] -> [a]
sinRepetir [] = []
sinRepetir (x:xs) = x : sinRepetir (filter (/= x) xs)