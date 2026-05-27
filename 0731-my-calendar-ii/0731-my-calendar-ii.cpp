class MyCalendarTwo {
    map<int,int>mp;
public:
    MyCalendarTwo() {  
    }
    
    bool book(int startTime, int endTime) {
        mp[startTime]++; mp[endTime]--;
        int prefix=0;
        for(auto it:mp){
            prefix+=it.second;
            if(prefix==3){
                mp[startTime]--; mp[endTime]++;
                return false;
            }
        }
        return true;
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(startTime,endTime);
 */