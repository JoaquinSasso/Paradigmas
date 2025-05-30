sumaMatriz :: (Integral a) => [[a]] -> [[a]] -> [[a]]
--sumaMatriz a b = zipWith (zipWith (+)) a b
sumaMatriz (x:[]) (y:[]) = [zipWith (+) x y]
sumaMatriz (x:a) (y:b) = (zipWith (+) x y) : (sumaMatriz a b)