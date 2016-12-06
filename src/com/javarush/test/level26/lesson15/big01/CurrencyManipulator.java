package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;


public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations=new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        //this.denominations=new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
        //, который вернет true, если денег достаточно для выдачи.
    }


     public Map<Integer, Integer> withdrawAmount ( int expectedAmount) throws NotEnoughMoneyException {

        ConcurrentNavigableMap<Integer, Integer> map = ((ConcurrentSkipListMap<Integer, Integer>) denominations).descendingMap();
        if (map.isEmpty()) throw new NotEnoughMoneyException();
        Integer[] values, ammounts;
        int price, position, count = map.keySet().size();
        values = map.keySet().toArray(new Integer[count]);
        ammounts = map.values().toArray(new Integer[count]);
        //Greedy algorithm
        List<Integer[]> variations = WithdrawSolutions.withdrawSolutions(values, ammounts, new int[count], expectedAmount, 0);
        if (variations.isEmpty())
            throw new NotEnoughMoneyException();

        //Finding best choice

        // Find the smallest number of banknotes in variations
        int minBanknotesNumber = Integer.MAX_VALUE;
        int[] bankNotesNumbers = new int[variations.size()];
        // and compute hash to identify variation with more large denomination baknotes
        int step = 0;
        for (Integer v : map.values())
        {
            if (v > step) step = v;
        }
        BigInteger[] hashes = new BigInteger[variations.size()];
        for (int i = 0; i < hashes.length; i++)
        {
            hashes[i] = BigInteger.ZERO;
        }
        for (int i = 0; i < variations.size(); i++)
        {
            Integer[] variationsI = variations.get(i);
            BigInteger base = BigInteger.valueOf(1);
            int banknotesNumberI = 0;
            for (Integer var : variationsI)
            {
                if (var != 0)
                {
                    hashes[i] = hashes[i].add(base.multiply(BigInteger.valueOf(var)));
                    banknotesNumberI += var;
                }
                base = base.multiply(BigInteger.valueOf(step));
            }
            bankNotesNumbers[i] = banknotesNumberI;
            if (banknotesNumberI < minBanknotesNumber) minBanknotesNumber = banknotesNumberI;
        }
        // Best variation must have biggest hash among variations with smallest number of banknotes
        int maxHashI = -1;
        for (int i = 0; i < hashes.length; i++)
            if (bankNotesNumbers[i] == minBanknotesNumber)
            {
                if (maxHashI == -1)
                { //first match
                    maxHashI = i;
                    continue;
                }
                BigInteger hash = hashes[i];
                if (hash.compareTo(hashes[maxHashI]) > 0)
                    maxHashI = i;
            }
        Integer[] bestChoice = variations.get(maxHashI);

        // Fill in best choice into result variable
        Map<Integer, Integer> withdrawBanknotes = new HashMap<Integer, Integer>();
        for (int i = bestChoice.length - 1; i >= 0; i--)
        {
            Integer b = bestChoice[i];
            if (b != 0)
                withdrawBanknotes.put(values[i], b);
        }

        // withdraw result from CurrencyManipulator
        for (Integer key : withdrawBanknotes.keySet())
        {
            int newAmmount = denominations.get(key) - withdrawBanknotes.get(key);
            if (newAmmount == 0) denominations.remove(key);
            else denominations.put(key, newAmmount);
        }

        return withdrawBanknotes;
    }


        public void clear() {
        denominations = new ConcurrentSkipListMap<Integer, Integer>();
    }

}
