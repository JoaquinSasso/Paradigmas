sumaC :: (Integral a) => [[a]] -> [a]
sumaC x = [sum[real | [real, _] <- x], sum [img | [_,img] <-x ]]