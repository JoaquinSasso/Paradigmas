sumaP :: (Integral a) => [[a]] -> [[a]]-> [[a]]


sumaP x [] = x
sumaP [] y = y
sumaP (x:xs) (y:ys) 
   | last y == last x = [head x + head y, last x]: sumaP xs ys
   | last y > last x = y : sumaP (x:xs) ys
   | otherwise = x : sumaP xs (y:ys)