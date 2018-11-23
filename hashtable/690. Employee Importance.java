// https://leetcode.com/problems/employee-importance/
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        return sum(map, id);
    }
    
    private int sum(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int res = e.importance;
        
        for (int subid : e.subordinates) {
            res += sum(map, subid);
        }
        
        return res;
    }
}
