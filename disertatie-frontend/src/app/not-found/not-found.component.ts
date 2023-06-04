import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit {
  
  @Input() visible: boolean = false;
  @Input() notFoundMessage: string = "Nu am gasit ceea ce cautai!";
  @Input() resetLinkText: string = "Reseteaza cautarea";
  @Input() resetLinkRoute: string = "/";

  constructor() { }

  ngOnInit(): void {
  }

}
