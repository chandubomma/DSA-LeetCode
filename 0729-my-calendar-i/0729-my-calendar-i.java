class MyCalendar {
    ArrayList<Event> events ;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(Event e : events){
            if(!check(e.start,e.end,start,end))return false;
        }
        events.add(new Event(start,end));
        return true;
    }
    
    private boolean check(int s1,int e1,int s2,int e2){
        if(s2>=e1 || e2<=s1)return true;
        return false;
    }
    
    class Event{
        int start;
        int end;
        public Event(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */