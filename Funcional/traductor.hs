traduce ::  [String] -> [[String]] -> [String]

traduce [] y = []
traduce (x:xs) y  | elem x (map head y) = last ((last (filter (\p -> head p == x) y))) : traduce xs y
                  | otherwise = "*" : traduce xs y 
