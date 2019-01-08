# Mayın Tarlası Oyunu 


### Genel Kurallar

>Oyun 9x9 luk bir matris üzerine kurulmuştur. </br>
>Mayinlar harita üzerine rastgele yerleştirilir ve mayın sayısı 10-49 arası random olarak üzretilir. </br>
>Kaç mayın olduğu kullanıcıya gösterilir ve mayın sayısı kadar Flag koyma hakkı verilir. </br>
>Flaglar mayın olduğu düşünülen noktalara konulabilir ve istenildiği zaman tekrar Flag geri alınabilir. </br>
>Her bölmede 8 komşusundaki mayın sayısı tutulmaktadır. Ve bu bilgiler ışığında tahminler yapılabilir. </br>


### Girdi Bilgileri

- Mayın tahmin ederken başına 'M' harfi konularak ilgili bölüm numarası girilir.
- Flag seçimi yapılırken ise 'F' ile girdi başlatılır. 
- Konulan Flagın iptal edilmesi için daha önce flag olarak işaretlenen bölmenin tekrar 'F' harfi ile girilirse flag kaldırılır 
- Girdiler büyük küçük harf duyarlılığı yoktur. Büyük veya küçük girilebilir hata vermez.
  
  
----------------------------------------------------------------------------------
## Claslar

Uygulama yazılırken 5 class halinde yazıldı. Bunlardan ilki "main" metodunu tutan ve uygulamanın tetiklendiği [Runner](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Runner.java) classı. Harita bilgilerinin tutulduğu 
[Map](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Map.java) classı. Oyun kontrollerinin yapıldığı
[Logic](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Logic.java) classı. Oyuncu girdisinin alındığı 
[Player](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Player.java) classı. Ve son olarak 
oyunun başlatıldığı ve haritanın güncellendiği [MineField](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/MineField.java) classı.

### [MAP](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Map.java)

Map classında harita oluşturularak harita bilgileri tutulmaktadır. Harita static olarak tanımlanmıştır ve uygulama boyunca 
tektir ve heryerden erişilebilir ve değişiklikler anında uygulanabilir.

1. resetTable metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Harita bu metodla 0'larla doldurulmaktadır. Tablonun başlangıc değerleri 0'dır. Ve tablo resetlenir.
   
2. randomGenerateMine metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Mayınlar rastgele üretilmektedir. (10-49 arası random bi değerdir.)
   
3. randomArrangeMine metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Üretilen mayınları haritanın üzerine rastgele olarak yerleştirmektedir. 
   - Mayınlar yerleştirilirken daha önce o bölmede mayın olup olmadığı kontrol edilir. Ve tüm mayınlar harita üzerine yerleştirilir.
 
 4. foundMineNumber metodu
    - Metod int bir değer döndürür ve iki int parametre alır. 
    - Bu metodda gönderilen konumun 8 komşuluğunda bulunan mayın sayısı hesaplanır. 
    - Bu mayın sayısını geri döndürür.
 
 5. arrangeMine metodu
    - Metod void metoddur ve geri dönüş değeri yoktur.
    - Metod tüm haritayı gezer. O noktanın komşulukların mayın adetlerini haritaya işler.
    - Komşuluk mayın sayısı bulunurken foundMineNumber metodu çağrılır.
    
 6. finishTable metodu 
    - Metod void metoddur ve geri dönüş değeri yoktur.
    - Oyun sonlandığında kullanıcıya harita bilgilerini gösterir. Oyun sonu haritasıdır.
    
### [LOGIC](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/Logic.java)

Logic classında oyun kontrolleri yapılmaktadır. Oyun kazanıldı mı? yoksa kaybedildi mi?


1. ifLossGame metodu
   - Metod boolean bir değer döndürür ve int 2 parametre alır.
   - Eğer parametre olarak gönderilen koordinatlarda mayın varsa true, yoksa false bir değer döndürür.
   
2. ifFinishGame metodu
   - Metod boolean bir değer döndürür ve int bir parametre alır.
   - Metod hamle sayısını hesaplar. Eğer yapılacak hamle yoksa false, hamleler bitmedi ise true değer döndürür.
   
### [MINEFIELD](https://github.com/Mustafa1919/mayintarlasi/blob/master/src/mustafa/main/MineField.java)

Bu classta harita kullanıcıya hazırlanır. Ara bir harita oluşturulur. Bilgilerin tutulduğu haritada kontroller yapılır ve ara 
harita kullanıcıya gösterilir ve girdiler bu harita üzerinden alınır. Bu sayede static olan ana haritamızda istenmeyen değişikler 
olmasının önüne geçilir. 
   
1. initField metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Kullanıcı haritası hazırlanır. İlk değerleri yerleştirilir. Ve kullanıcıya gösterilecek görsellik verilir.
   - Her bölmenin bir numarası bulunmaktadır ve bu numaraların başına M harfi yazılarak seçime hazır olduğu gösterilmektedir.
   
2. printField metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Oluşturulan kullanıcı haritası ekrana yazılır ve flag ve mayın bilgileri kullanıcıya gösterilir.
   
3. startGame metodu
   - Metod void metoddur ve geri dönüş değeri yoktur.
   - Oyuna startın verildiği metoddur. 
   - Gerekli başlangıc değerleri tanımlandıktan sonra (muhtemel hamle sayısı, mayın sayısı , flag sayısı vb.) oyun döngüsü başlatılır.
   - En dışta bir while döngüsü ile yapılacak hamle olmayana kadar devam eder. 
   - Oyuncudan seçim bilgileri alındıktan sonra gerekli metodlar çağrılarak oyunun kontrolleri yapılır (seçilen bölüm mayın mı?,  Flag yerleştirilmek mi isteniyor? , seçilen flag iptal mi ediliyor).
