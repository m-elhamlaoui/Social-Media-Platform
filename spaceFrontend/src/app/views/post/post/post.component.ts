import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { Post } from '../../../models/Post/post';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [FormsModule, ButtonModule ],
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent {
  @Input() post!: Post;


}
