package entity;

public class Page {
    private Integer start;
    private Integer count;
    private Integer total;

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;
    }

    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        if (total % count== 0)
            totalPage = total /count;
        else
            totalPage = total / count + 1;
        if(totalPage==0)
            totalPage = 1;
        System.out.println(totalPage);
        return totalPage;
    }

    public int getLast(){
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        last = last<0?0:last;
        return last;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
