union :: (Ord a) => [a] -> [a] -> [a]
union a [] = a
union a (x : b)
   | elem x a = union a b
   | otherwise = union (a ++ [x]) b