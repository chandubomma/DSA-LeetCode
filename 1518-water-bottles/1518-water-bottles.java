class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles<numExchange)return numBottles;
       return numBottles-numBottles%numExchange + numWaterBottles(numBottles/numExchange+numBottles%numExchange,numExchange);
    }
}