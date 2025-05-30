insertar :: (Ord a) => [a] -> a -> [a]
insertar (x: li) a
   | x > a = a : (x : li)
   | otherwise = x : insertar li a
