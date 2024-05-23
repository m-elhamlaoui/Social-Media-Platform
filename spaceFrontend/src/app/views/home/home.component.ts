import { Component } from '@angular/core';
import { PostComponent } from '../post/post/post.component';
import { CommonModule } from '@angular/common';
import { PostService } from '../../controllers/post/post.service';
import { Post } from '../../models/Post/post';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [PostComponent,CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  posts: Post[] = [];

  constructor(private postService: PostService) {}

  
}
