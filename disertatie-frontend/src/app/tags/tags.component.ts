import { Component, Input, OnInit } from '@angular/core';
import { FoodService } from '../services/food/food.service';
import { Tag } from '../shared/models/Tag';
import { TagsService } from '../services/tags/tags.service';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {

  tags?:Tag[];

  @Input()
  foodPageTags?:string[];

  @Input()
  justifyContent:string = 'center';

  constructor(private foodService:FoodService, private tagsService: TagsService) { }

  ngOnInit(): void {
    if(!this.foodPageTags)
    this.getTagsCounted();
    // this.tags =  this.foodService.getAllTag();
    // this.tagsService.getTagCounted();
  }

  getTagsCounted() {
    this.tagsService.getTagCountedRequest().subscribe( response => {
      this.tags = response;
    })

  }

}
