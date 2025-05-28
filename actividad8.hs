sinRepetir :: Eq a => [a] -> [a]
sinRepetir [] = []
--sinRepetir (x:xs) = x : sinRepetir (filter (/= x) xs)
sinRepetir (x:xs) | elem x xs = sinRepetir xs
                  | otherwise = x : sinRepetir xs