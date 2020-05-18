let rec pow a n = 
    if (n <= 0) then 1
    else (pow a (n - 1)) * a ;;

pow 3 4;;
pow 2 10;;