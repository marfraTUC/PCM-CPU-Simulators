#!/bin/bash
#clear file
echo -n "" > BankInput.txt

accountNumber=2000
balanceRange=9999
transactionNumber=2000000
maxTrabsactionAmount=700

counter=0
while [ $counter -lt $accountNumber ]; do
    randomNumber=$RANDOM
    let "randomNumber %= $balanceRange"
    let balance=randomNumber+1
    echo $balance >> BankInput.txt
    let counter=counter+1
done

echo -e "\r" >> BankInput.txt

counter=0
while [ $counter -lt $transactionNumber ];do
    randomSrcAcc=$RANDOM
    randomTrgAcc=$RANDOM
    randomAmount=$RANDOM

    let "randomSrcAcc %= $accountNumber"
    let "randomTrgAcc %= $accountNumber"

    if [ $randomSrcAcc -ne $randomTrgAcc ]
    then
        let "randomAmount %= $maxTrabsactionAmount"
        let randomAmount=randomAmount+5
        echo $randomSrcAcc $randomTrgAcc $randomAmount >> BankInput.txt
        let counter=counter+1
    fi
done

