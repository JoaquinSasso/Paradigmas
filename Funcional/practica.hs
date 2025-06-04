promedio :: [Int] -> Int
promedio x = sum x `div` length x

mayoresPromedio :: [[Int]] -> [[Int]]
mayoresPromedio x = [ [n | n <- li, n > promedio li] | li <- x ]

sinRepetidos :: (Eq a) => [a] -> [a]
sinRepetidos [] = []
sinRepetidos (x:xs) = x : sinRepetidos (filter (/= x) xs)

aprobadosPorMateria :: [[String]] -> String -> [String]
aprobadosPorMateria li mat = [head a | a <- li, last a == mat, a !! 1 >= "6"]

interseccion :: (Eq a) => [a] -> [a] -> [a]
interseccion x y = [a | a <- x, b <- y, a == b]