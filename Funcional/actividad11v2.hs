complejos :: (Integral a) => [[a]] -> [a]

complejos li = [sum[head x | x <- li], sum[last x | x <- li]]