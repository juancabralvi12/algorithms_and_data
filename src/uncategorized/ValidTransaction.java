/*
A transaction is possibly invalid if:

-the amount exceeds $1000, or;
-if it occurs within (and including) 60 minutes of another transaction
with the same name in a different city.


Each transaction string transactions[i] consists of comma separated
values representing the name, time (in minutes), amount, and city of
the transaction.

Given a list of transactions, return a list of transactions that are
possibly invalid.  You may return the answer in any order.

Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second
transaction occurs within a difference of 60 minutes, have the same
name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]


Constraints:

transactions.length <= 1000
Each transactions[i] takes the form "{name},{time},{amount},{city}"
Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
Each {time} consist of digits, and represent an integer between 0 and 1000.
Each {amount} consist of digits, and represent an integer between 0 and 2000.


Analysis

constrains

-the amount exceeds $1000, or;
-if it occurs within (and including) 60 minutes of another transaction
with the same name in a different city.


//transactions[i] = <name,time(in minutes),amount,city>
                             i                   j
//["alice,20,800,mtv", "alice,50,100,beijing"]
                                         i                      j
 alice -->  ["alice,20,800,mtv", "alice,50,100,beijing", "alice,90,800,mtv"]

 invalid("alice,20,800,mtv")
 invalid("alice,50,100,beijing")

  1. Have a set of strings -> S
  2. Have a map of name 2 all strins mapping that name
  3.
                                                  i                     j
  ["alice,20,800,mtv", "alice,30,800,mtv", "alice,40,800,gdl", "alice,300,100,beijing"]

  S = 1,2,3



*/



package uncategorized;

import java.util.*;

public class ValidTransaction {


	class Transaction {
		String name;
		int time;
		int amount;
		String city;
		String txn;

		public Transaction(String txn){
			this.txn = txn;
			String[] values = txn.split(",");
			name = values[0];
			time = Integer.parseInt(values[1]);
			amount = Integer.parseInt(values[2]);
			city = values[3];
		}

		public String toString(){
			return txn;
		}

	}

	public static void main(String []args){

		//System.out.println(new ValidTransaction().invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}));
		//System.out.println(new ValidTransaction().invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"}));
		//System.out.println(new ValidTransaction().invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}));
		//System.out.println(new ValidTransaction().invalidTransactions(new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}));
		//System.out.println(new ValidTransaction().invalidTransactions(new String[]{"lee,886,1785,beijing","alex,763,1157,amsterdam","lee,277,129,amsterdam","bob,770,105,amsterdam","lee,603,926,amsterdam","chalicefy,476,50,budapest","lee,924,859,barcelona","alex,302,590,amsterdam","alex,397,1464,barcelona","bob,412,1404,amsterdam","lee,505,849,budapest"}));
		System.out.println(new ValidTransaction().invalidTransactions(new String[]{"xnova,261,1949,chicago","bob,206,1284,chicago","xnova,420,996,bangkok","chalicefy,704,1269,chicago","iris,124,329,bangkok","xnova,791,700,amsterdam","chalicefy,572,697,budapest","chalicefy,231,310,chicago","chalicefy,763,857,chicago","maybe,837,198,amsterdam","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","lee,607,275,budapest","chalicefy,709,1171,amsterdam"}));
	}

	public List<String> invalidTransactions(String[] transactions) {
		//["bob,132,1219,barcelona","xnova,261,1949,chicago","chalicefy,709,1171,amsterdam","lee,69,857,barcelona","lee,99,940,bangkok","bob,206,1284,chicago","chalicefy,704,1269,chicago"]
		//["chalicefy,704,1269,chicago","chalicefy,763,857,chicago","chalicefy,709,1171,amsterdam"]
		Set<String> output = new HashSet<>();
		Map<String, List<Transaction>> map = new HashMap<>();

		for(String txn : transactions){
			Transaction t = new Transaction(txn);
			map.putIfAbsent(t.name, new ArrayList<>());
			map.get(t.name).add(t);
		}

		map.forEach((k,v) -> Collections.sort(v, (t1,t2) -> t1.time - t2.time));

		//["chalicefy,704,1269,chicago","chalicefy,763,857,chicago","chalicefy,709,1171,amsterdam"]
		for(String key : map.keySet()){
			List<Transaction> txns = map.get(key);
			Collections.sort(txns, (t1, t2) -> t1.time - t2.time);
			int i = 0;
			int j = 1;

			if (txns.size() > 0 && txns.get(i).amount > 1000) {
				output.add(txns.get(i).toString());
			}



			while(j<txns.size()){


				while (i<j && Math.abs(txns.get(j).time - txns.get(i).time) > 60){
					i++;
				}

				for(int idx=i; idx<j; idx++) {
					if (!txns.get(j).city.equals(txns.get(idx).city)) {
						output.add(txns.get(idx).toString());
						output.add(txns.get(j).toString());
					}
				}

				if (txns.get(j).amount > 1000) {
					output.add(txns.get(j).toString());
				}
				j++;
			}


		}
		return new ArrayList<>(output);
	}
}