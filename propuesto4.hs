scanner :: (Num a) => a -> [a] -> [a] 
scanner n [] = [n] 
scanner n (x:xs) = x + head (scanner n xs) : scanner n xs