import tester.*;

// constructor
class RoadTrip {
  String driver1;
  String driver2;
  ILoDirections directions;
  RoadTrip(String driver1, String driver2, ILoDirections directions){
    this.driver1 = driver1;
    this.driver2 = driver2;
    this.directions = directions;
  }
  // to get the name of driver1
  public String driver1name(){
    return this.driver1;
  }

  // to get the name of driver2
  public String driver2name() {
    return this.driver2name();
  }

  // to split up the trip
  public ILoRoadTripChunk splitUpTrip(int max) {
    return this.splitUpTripHelper(max,new MtLoRoadTripChunk());
  }

  public ILoRoadTripChunk splitUpTripHelper(int max, ILoRoadTripChunk chunks) {
        return this.directions.newRoadTripHelper(max, driver1, driver2,chunks)
            .reverse(new MtLoRoadTripChunk());
    
  }


}

// constructor
class RoadTripChunk{
  String driver;
  ILoDirections directions;
  RoadTripChunk(String driver, ILoDirections directions){
    this.driver = driver;
    this.directions = directions;
  }

}

// to represent RoadTripChunk
interface ILoRoadTripChunk{

  //get chunks
  ILoRoadTripChunk getNewChunk(direction dir, int n, String d);
  
  ILoRoadTripChunk reverse(ILoRoadTripChunk chunks);
}

// to represent empty case
class MtLoRoadTripChunk implements ILoRoadTripChunk{

  @Override
  public ILoRoadTripChunk getNewChunk(direction dir, int n,String d) {
    // TODO Auto-generated method stub
    return new ConsLoRoadTripChunk(new RoadTripChunk(d,
        new ConsLoDirections(new direction(dir.getdirection(),n),new MtLoDirections())),this);
  }

  @Override
  public ILoRoadTripChunk reverse(ILoRoadTripChunk chunks) {
    // TODO Auto-generated method stub
    return chunks;
  }

}

// to represent none empty case
class ConsLoRoadTripChunk implements ILoRoadTripChunk{
  RoadTripChunk first;
  ILoRoadTripChunk rest;
  ConsLoRoadTripChunk(RoadTripChunk first, ILoRoadTripChunk rest){
    this.first = first;
    this.rest = rest;
  }
  
  @Override
  public ILoRoadTripChunk getNewChunk(direction dir, int n,String d) {
    // TODO Auto-generated method stub
    return new ConsLoRoadTripChunk(new RoadTripChunk(d,
        new ConsLoDirections(new direction(dir.getdirection(),n),new MtLoDirections())),this);
  }

  @Override
  public ILoRoadTripChunk reverse(ILoRoadTripChunk chunks) {
    // TODO Auto-generated method stub
    return this.rest.reverse(new ConsLoRoadTripChunk(first,chunks));
  }

}

// to represent directions 
interface ILoDirections{
  ILoRoadTripChunk newRoadTripHelper(int max, String driver1, String driver2,ILoRoadTripChunk chunks);

  ILoDirections getNewDirection(int max);
}

// to represent empty case
class MtLoDirections implements ILoDirections{

  @Override
  public ILoRoadTripChunk newRoadTripHelper(int max, String driver1, String driver2, ILoRoadTripChunk chunks) {
    // TODO Auto-generated method stub
    return chunks;
  }

  @Override
  public ILoDirections getNewDirection(int max) {
    // TODO Auto-generated method stub
    return this;
  }

  

 
}

// to represent none empty case
class ConsLoDirections implements ILoDirections{
  direction first;
  ILoDirections rest;
  ConsLoDirections(direction first, ILoDirections rest){
    this.first = first;
    this.rest = rest;
  }
  
  @Override
  public ILoRoadTripChunk newRoadTripHelper(int max, String driver1, String driver2, ILoRoadTripChunk chunks) {
    // TODO Auto-generated method stub
    if (this.first.getMile() > max)  {
      return this.getNewDirection(max).newRoadTripHelper(max, driver2, driver1, chunks.getNewChunk(this.first,max, driver1));
    }
    else {
      return this.rest.newRoadTripHelper(max - this.first.getMile(), driver1, driver2, 
          chunks.getNewChunk(this.first, this.first.getMile(), driver1));
    }
  }

  @Override
  public ILoDirections getNewDirection(int max) {
    return new ConsLoDirections(new direction(this.first.getdirection(), this.first.getMile() - max),this.rest);
  }
  

  
}

// to represent direction
class direction  {
  String description;
  int mile;
  direction(String description, int mile){
    this.description = description;
    this.mile = mile;
  }
  // return string
  String getdirection() {
    return this.description + ",";
  }
  // return mile
  int getMile() {
    return this.mile;
  }
}

// Examples
class ExamplesPlaces{
  direction D1 = new direction ("Make a left at Alberquerque" , 13);
  direction D2 = new direction ("Make a right at the fork" , 2);
  direction D3 = new direction ("Make a left at the next fork", 3);
  direction D4 = new direction ("Take the overpass", 45);
  direction D5 = new direction ("Destination on left", 12);


  ILoDirections DS1 = new MtLoDirections ();
  ILoDirections DS2 = new ConsLoDirections (this.D1, this.DS1); 
  ILoDirections DS3 = new ConsLoDirections (this.D2, this.DS2); 
  ILoDirections DS4 = new ConsLoDirections (this.D3, this.DS3); 
  ILoDirections DS5 = new ConsLoDirections (this.D4, this.DS4); 
  ILoDirections DS6 = new ConsLoDirections (this.D5, this.DS5); 


  RoadTrip R1 = new RoadTrip("Hazel", "Henrry", DS1);
  RoadTrip R2 = new RoadTrip("Hazel", "Henrry", DS2);
  RoadTrip R3 = new RoadTrip("Hazel", "Henrry", DS3);
  RoadTrip R4 = new RoadTrip("Hazel", "Henrry", DS4);
  RoadTrip R5 = new RoadTrip("Hazel", "Henrry", DS5);

}