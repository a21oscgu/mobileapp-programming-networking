
# Rapport

# Assignment 5: Networking

**Den här appen är forkad från LenaSYS/mobileapp-programming-networking. Appen har en <i>RecyclerView</i> i Main-Activity vilket är appens startsida, där varje list-item är en <i>TextView</i>. En arraylist ”MountainsArray” har lagts till som en variabel i <i>MainActivity.java</i>, se kodsnutt 1:**

```
ArrayList<Mountain> mountainsArray;
```

**En RecyclerView.Adapter har också lagts till som en variabel i <i>MainActivity.java</i>, se kodsnutt 2:**

```
RecyclerView recyclerView;
```

**Den <i>RecyclerView</i> som har skapats har fått en <i>Adapter</i> "MyAdapter" och en <i>ViewHolder</i> "MyViewHolder". För att placera nammnen på alla bergen, som finns i "FamousPeaksJSON", i min <i>RecyclerView</i> har ett antal steg utförts. Det första var att ladda ned JSON-datan och konvertera den till ett java-objekt m.h.a. GSON (Unmarshall JSON). Därefter fick data-informationen delas upp i ett antal strängar och heltal, se klassen "Mountain.java". Sedan skapades en for-loop i "onPostExecute()" som går igenom java-objektet och lägger till varje bergs-namn i listan "MountainsArray", som slutligen presenteras i min <i>RecyclerView</i>, d.v.s. informationen presenteras i listan som finns på startsidan i appen.**


**Detta skärmklipp visar den <i>RecyclerView</i> som finns på startsidan i appen:**

<img src="/Screenshot_20220502_123357.png" width="60%">