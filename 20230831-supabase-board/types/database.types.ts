export type Json =
  | string
  | number
  | boolean
  | null
  | { [key: string]: Json | undefined }
  | Json[];

export interface Database {
  public: {
    Tables: {
      posts: {
        Row: {
          content: string | null;
          created_at: string;
          deleted: boolean;
          id: number;
          title: string | null;
          updated_at: string | null;
          user_id: number;
        };
        Insert: {
          content?: string | null;
          created_at?: string;
          deleted?: boolean;
          id?: number;
          title?: string | null;
          updated_at?: string | null;
          user_id: number;
        };
        Update: {
          content?: string | null;
          created_at?: string;
          deleted?: boolean;
          id?: number;
          title?: string | null;
          updated_at?: string | null;
          user_id?: number;
        };
        Relationships: [
          {
            foreignKeyName: 'posts_user_id_fkey';
            columns: ['user_id'];
            referencedRelation: 'users';
            referencedColumns: ['id'];
          },
        ];
      };
      users: {
        Row: {
          created_at: string;
          email: string | null;
          id: number;
          password: string | null;
        };
        Insert: {
          created_at?: string;
          email?: string | null;
          id?: number;
          password?: string | null;
        };
        Update: {
          created_at?: string;
          email?: string | null;
          id?: number;
          password?: string | null;
        };
        Relationships: [];
      };
    };
    Views: {
      [_ in never]: never;
    };
    Functions: {
      [_ in never]: never;
    };
    Enums: {
      [_ in never]: never;
    };
    CompositeTypes: {
      [_ in never]: never;
    };
  };
}
