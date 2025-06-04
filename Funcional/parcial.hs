funcion :: (Integral a) => [[a]] -> [[a]]
funcion (x:xs) 
   | null xs = [[a] | a <- x]
   | otherwise = zipWith (:) x (funcion xs)

divisores :: (Integral a) => a -> [a]
divisores n = calcular n 1

calcular :: (Integral a) => a -> a -> [a]
calcular n d 
   | n == d = [n]
   | mod n d == 0 = d : calcular n (d+1)
   | otherwise = calcular n (d+1)


uneListas :: (Ord a) => [a] -> [a] -> [a]

uneListas [] ordenada = ordenada
uneListas (x:xs) ordenada = uneListas xs (inserta x ordenada)

inserta :: (Ord a) => a -> [a] -> [a]
inserta x [] = [x]
inserta x (y:ys) 
   | x < y = x : (y : ys)
   | otherwise = y : inserta x ys
