import { Component, OnInit } from '@angular/core';
import {Chart, registerables} from 'chart.js'
import { ChartData } from '../shared/models/ChartData';
import { map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
Chart.register(...registerables);

@Component({
  selector: 'app-graphs',
  templateUrl: './graphs.component.html',
  styleUrls: ['./graphs.component.css']
})
export class GraphsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.requestChartData();
  }

  requestChartData(){
    return this.http.get("http://localhost:8080/api/food/get-chart-data")
    .pipe(
      map( response => {
        const responseArray: ChartData[] = [];

        for(const key in response) {
          if(response.hasOwnProperty(key)) {
            responseArray.push({
              foodName: response[key].foodName,
              foodQuantity: response[key].foodQuantity
            })
          }
        }
        return responseArray;
      })
    )
    .subscribe( response => {

      const foodNameArray: String[] = [];
      const foodQuantityArray: Number[] = [];
    
      for(let i = 0; i<response.length; i++) {
        foodNameArray.push(response[i].foodName);
        foodQuantityArray.push(response[i].foodQuantity);
      }

      const background_color = [];
      const border_color = [];

   for(let i=0; i< foodNameArray.length; i++) {
    const r =  Math.floor(Math.random() * 255);
    const g =  Math.floor(Math.random() * 255);
    const b =  Math.floor(Math.random() * 255);

    background_color.push('rgba('+r+','+g+','+b+', 0.5)');
    border_color.push('rgba('+r+','+g+','+b+', 1)');
   }

    new Chart("piechart", {
      type: 'bar',
      data: {
        labels: foodNameArray,
        datasets: [{
          label: null,
          data: foodQuantityArray,
          borderWidth: 1,
          backgroundColor: background_color,
          borderColor: border_color
        }]
      },
      options: {
        plugins: {
          legend: {
            display: false
          }
        },
        // scales: {
        //   y: {
        //     beginAtZero: true
        //   }
        // },
        indexAxis: 'y',
        
      }
    });
    })
  }

}
