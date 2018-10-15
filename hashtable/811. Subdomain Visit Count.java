// https://leetcode.com/problems/subdomain-visit-count/
class Solution { // 89 ms
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        
        for (String s : cpdomains) {
            String[] splited = s.split(" ");
            int count = Integer.valueOf(splited[0]);
            String domain = splited[1];
            
            int i = 0;
            do {
                System.out.println(domain);
                map.put(domain, map.getOrDefault(domain, 0) + count);
                
                i = domain.indexOf('.');
                domain = domain.substring(i + 1, domain.length());
            } while (i != -1);
            
        }
        
        List<String> res = new ArrayList();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            res.add(e.getValue() + " " + e.getKey());
        }
        
        return res;
    }
}
