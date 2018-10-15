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

class Solution { \\ 21 ms
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        
        for (String s : cpdomains) {
            String[] splited = s.split(" ");
            int count = Integer.valueOf(splited[0]);
            splited = splited[1].split("\\.");
            
            String d = splited[splited.length - 1];
            map.put(d, map.getOrDefault(d, 0) + count);
            
            for (int i = splited.length - 2; i >= 0; i--) {
                d = splited[i] + "." + d;
                map.put(d, map.getOrDefault(d, 0) + count);
            }
        }
        
        List<String> res = new ArrayList();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            res.add(e.getValue() + " " + e.getKey());
        }
        
        return res;
    }
}
