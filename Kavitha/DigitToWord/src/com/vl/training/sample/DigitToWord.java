//package com.vl.training.sample;
public class DigitToWord {
	public static void main(final String[] args) {

		DigitToWord.getWord(args);

	}
	static void getWord(String[] a) {
		int len=a[0].toCharArray().length;
		int num=Integer.parseInt(a[0]);

		String []ones={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
		String []tens={"","","Twenty","Thirty","Forty","Fifity","Sixty","Seventy","Eighty","Ninety"};

		int tsnd,hnd,ten,one;
		if(len==4) {
			tsnd=num/1000;
			num=num%1000;
			if(num==0) {
				System.out.println(ones[tsnd]+ " Thousand");
			} 
			else {

				hnd=num/100;
				num=num%100;
				if(num==0) {
					System.out.println(ones[tsnd]+ " Thousand " +ones[hnd]+ " Hundred");
				} 
				else {
					if(num>19) {
						ten=num/10;
						num=num%10;
						one=num;
						System.out.println(ones[tsnd]+ " Thousand " +ones[hnd]+ " Hundred  And " +tens[ten]+ " " +ones[one]);
					}
					else {
						System.out.println(ones[tsnd]+ " Thousand " +ones[hnd]+ " Hundred And " +ones[num]);
					} 
				} 
			}
		}
		if(len==3) {
			hnd=num/100;
			num=num%100;
			if(num==0) {
				System.out.println(ones[hnd]+ " Hundred");
			}
			else { 
				if(num>19) {
					ten=num/10;
					num=num%10;
					one=num;
					System.out.println(ones[hnd]+ " Hundred And " +tens[ten]+ " " +ones[one]);
				}
				else {
					System.out.println(ones[hnd]+ " Hundred " +ones[num]);
				}  
			}  
		}
		if(len==2) {
			if(num>19) {
				ten=num/10;
				num=num%10;
				one=num;
				System.out.println(tens[ten]+ " " +ones[one]);
			}
			else {

				System.out.println(ones[num]);
			}  
		}
	}
}
