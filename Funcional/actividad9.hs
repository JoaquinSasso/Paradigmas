binario :: (Integral a) => a -> [a]
binario x 
   | x < 2 = [x]  
   | otherwise = binario (div x 2) ++ [mod x 2]
